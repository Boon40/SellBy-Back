package com.sellby.sellby.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sellby.sellby.mapper.ProductPhotoMapper;
import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.ProductPhoto;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.enums.CategoryEnum;
import com.sellby.sellby.model.enums.StateEnum;
import com.sellby.sellby.model.request.ProductPhotoRequest;
import com.sellby.sellby.model.response.CategoryResponse;
import com.sellby.sellby.model.response.ProductPhotoResponse;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.model.response.StateResponse;
import com.sellby.sellby.model.response.UserResponse;
import com.sellby.sellby.repository.ProductPhotoRepository;
import com.sellby.sellby.repository.ProductRepository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ExtendWith(MockitoExtension.class)
class ProductPhotoServiceDiffblueTest {
    @Mock
    private ProductPhotoMapper productPhotoMapper;

    @Mock
    private ProductPhotoRepository productPhotoRepository;

    @InjectMocks
    private ProductPhotoService productPhotoService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductService productService;

    /**
     * Method under test: {@link ProductPhotoService#getAllProductPhotos()}
     */
    @Test
    void testGetAllProductPhotos() {
        when(productPhotoRepository.findAll()).thenReturn(new ArrayList<>());
        List<ProductPhotoResponse> actualAllProductPhotos = productPhotoService.getAllProductPhotos();
        verify(productPhotoRepository).findAll();
        assertTrue(actualAllProductPhotos.isEmpty());
    }

    /**
     * Method under test: {@link ProductPhotoService#getProductPhotos(int)}
     */
    @Test
    void testGetProductPhotos() {
        when(productPhotoRepository.getProductPhotos(Mockito.<Product>any())).thenReturn(new ArrayList<>());

        Category category = new Category();
        category.setCategory(CategoryEnum.Art);
        category.setId(1);

        User seller = new User();
        seller.setCity("Oxford");
        seller.setCountry("GB");
        seller.setCreatedDate(LocalDate.of(1970, 1, 1));
        seller.setEmail("jane.doe@example.org");
        seller.setFirst_name("Jane");
        seller.setId(1);
        seller.setLast_name("Doe");
        seller.setNumber("42");
        seller.setPassword_hash("Password hash");
        seller.setProducts(new ArrayList<>());
        seller.setReceivedComments(new ArrayList<>());
        seller.setSendComments(new ArrayList<>());

        State state = new State();
        state.setId(1);
        state.setState(StateEnum.LIKE_NEW);

        Product product = new Product();
        product.setBuyerPayingDelivery(true);
        product.setCategory(category);
        product.setCreatedDate(LocalDate.of(1970, 1, 1));
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setName("Name");
        product.setPhotos(new ArrayList<>());
        product.setPrice(10.0f);
        product.setSeller(seller);
        product.setState(state);
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        List<ProductPhotoResponse> actualProductPhotos = productPhotoService.getProductPhotos(1);
        verify(productPhotoRepository).getProductPhotos(Mockito.<Product>any());
        verify(productRepository).findById(Mockito.<Long>any());
        assertTrue(actualProductPhotos.isEmpty());
    }

    /**
     * Method under test: {@link ProductPhotoService#getProductPhotoById(int)}
     */
    @Test
    void testGetProductPhotoById() {
        Category category = new Category();
        category.setCategory(CategoryEnum.Art);
        category.setId(1);

        User seller = new User();
        seller.setCity("Oxford");
        seller.setCountry("GB");
        seller.setCreatedDate(LocalDate.of(1970, 1, 1));
        seller.setEmail("jane.doe@example.org");
        seller.setFirst_name("Jane");
        seller.setId(1);
        seller.setLast_name("Doe");
        seller.setNumber("42");
        seller.setPassword_hash("Password hash");
        seller.setProducts(new ArrayList<>());
        seller.setReceivedComments(new ArrayList<>());
        seller.setSendComments(new ArrayList<>());

        State state = new State();
        state.setId(1);
        state.setState(StateEnum.LIKE_NEW);

        Product product = new Product();
        product.setBuyerPayingDelivery(true);
        product.setCategory(category);
        product.setCreatedDate(LocalDate.of(1970, 1, 1));
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setName("Name");
        product.setPhotos(new ArrayList<>());
        product.setPrice(10.0f);
        product.setSeller(seller);
        product.setState(state);

        ProductPhoto productPhoto = new ProductPhoto();
        productPhoto.setId(1);
        productPhoto.setPath("Path");
        productPhoto.setProduct(product);
        Optional<ProductPhoto> ofResult = Optional.of(productPhoto);
        when(productPhotoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        ProductPhoto actualProductPhotoById = productPhotoService.getProductPhotoById(1);
        verify(productPhotoRepository).findById(Mockito.<Long>any());
        assertSame(productPhoto, actualProductPhotoById);
    }

    /**
     * Method under test: {@link ProductPhotoService#addProductPhoto(ProductPhotoRequest)}
     */
    @Test
    void testAddProductPhoto() throws Exception {
        Category category = new Category();
        category.setCategory(CategoryEnum.Art);
        category.setId(1);

        User seller = new User();
        seller.setCity("Oxford");
        seller.setCountry("GB");
        seller.setCreatedDate(LocalDate.of(1970, 1, 1));
        seller.setEmail("jane.doe@example.org");
        seller.setFirst_name("Jane");
        seller.setId(1);
        seller.setLast_name("Doe");
        seller.setNumber("42");
        seller.setPassword_hash("Password hash");
        seller.setProducts(new ArrayList<>());
        seller.setReceivedComments(new ArrayList<>());
        seller.setSendComments(new ArrayList<>());

        State state = new State();
        state.setId(1);
        state.setState(StateEnum.LIKE_NEW);

        Product product = new Product();
        product.setBuyerPayingDelivery(true);
        product.setCategory(category);
        product.setCreatedDate(LocalDate.of(1970, 1, 1));
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setName("Name");
        product.setPhotos(new ArrayList<>());
        product.setPrice(10.0f);
        product.setSeller(seller);
        product.setState(state);

        ProductPhoto productPhoto = new ProductPhoto();
        productPhoto.setId(1);
        productPhoto.setPath("Path");
        productPhoto.setProduct(product);
        when(productPhotoRepository.save(Mockito.<ProductPhoto>any())).thenReturn(productPhoto);

        Category category2 = new Category();
        category2.setCategory(CategoryEnum.Art);
        category2.setId(1);

        User seller2 = new User();
        seller2.setCity("Oxford");
        seller2.setCountry("GB");
        seller2.setCreatedDate(LocalDate.of(1970, 1, 1));
        seller2.setEmail("jane.doe@example.org");
        seller2.setFirst_name("Jane");
        seller2.setId(1);
        seller2.setLast_name("Doe");
        seller2.setNumber("42");
        seller2.setPassword_hash("Password hash");
        seller2.setProducts(new ArrayList<>());
        seller2.setReceivedComments(new ArrayList<>());
        seller2.setSendComments(new ArrayList<>());

        State state2 = new State();
        state2.setId(1);
        state2.setState(StateEnum.LIKE_NEW);

        Product product2 = new Product();
        product2.setBuyerPayingDelivery(true);
        product2.setCategory(category2);
        product2.setCreatedDate(LocalDate.of(1970, 1, 1));
        product2.setDescription("The characteristics of someone or something");
        product2.setId(1);
        product2.setName("Name");
        product2.setPhotos(new ArrayList<>());
        product2.setPrice(10.0f);
        product2.setSeller(seller2);
        product2.setState(state2);

        ProductPhoto productPhoto2 = new ProductPhoto();
        productPhoto2.setId(1);
        productPhoto2.setPath("Path");
        productPhoto2.setProduct(product2);
        when(productPhotoMapper.toEntity(Mockito.<ProductPhotoRequest>any(), Mockito.<Product>any()))
                .thenReturn(productPhoto2);
        UserResponse seller3 = new UserResponse(1, "jane.doe@example.org", "42", "Jane", "Doe", "GB", "Oxford",
                LocalDate.of(1970, 1, 1));

        StateResponse state3 = new StateResponse(1, StateEnum.LIKE_NEW, "MD");

        CategoryResponse category3 = new CategoryResponse(1, CategoryEnum.Art, "Category String");

        ProductPhotoResponse productPhotoResponse = new ProductPhotoResponse(1, "Path",
                new ProductResponse(1, "Name", "The characteristics of someone or something", 10.0f, seller3, state3, category3,
                        true, LocalDate.of(1970, 1, 1)));

        when(productPhotoMapper.toResponse(Mockito.<ProductPhoto>any())).thenReturn(productPhotoResponse);

        Category category4 = new Category();
        category4.setCategory(CategoryEnum.Art);
        category4.setId(1);

        User seller4 = new User();
        seller4.setCity("Oxford");
        seller4.setCountry("GB");
        seller4.setCreatedDate(LocalDate.of(1970, 1, 1));
        seller4.setEmail("jane.doe@example.org");
        seller4.setFirst_name("Jane");
        seller4.setId(1);
        seller4.setLast_name("Doe");
        seller4.setNumber("42");
        seller4.setPassword_hash("Password hash");
        seller4.setProducts(new ArrayList<>());
        seller4.setReceivedComments(new ArrayList<>());
        seller4.setSendComments(new ArrayList<>());

        State state4 = new State();
        state4.setId(1);
        state4.setState(StateEnum.LIKE_NEW);

        Product product3 = new Product();
        product3.setBuyerPayingDelivery(true);
        product3.setCategory(category4);
        product3.setCreatedDate(LocalDate.of(1970, 1, 1));
        product3.setDescription("The characteristics of someone or something");
        product3.setId(1);
        product3.setName("Name");
        product3.setPhotos(new ArrayList<>());
        product3.setPrice(10.0f);
        product3.setSeller(seller4);
        product3.setState(state4);
        when(productService.getProductEntityById(anyInt())).thenReturn(product3);
        ProductPhotoResponse actualAddProductPhotoResult = productPhotoService
                .addProductPhoto(new ProductPhotoRequest("Path", 1));
        verify(productPhotoMapper).toEntity(Mockito.<ProductPhotoRequest>any(), Mockito.<Product>any());
        verify(productPhotoMapper).toResponse(Mockito.<ProductPhoto>any());
        verify(productService).getProductEntityById(anyInt());
        verify(productPhotoRepository).save(Mockito.<ProductPhoto>any());
        assertSame(productPhotoResponse, actualAddProductPhotoResult);
    }

    /**
     * Method under test: {@link ProductPhotoService#addProductPhoto(ProductPhotoRequest)}
     */
    @Test
    void testAddProductPhoto2() throws Exception {
        when(productPhotoMapper.toEntity(Mockito.<ProductPhotoRequest>any(), Mockito.<Product>any()))
                .thenThrow(new Exception("foo"));

        Category category = new Category();
        category.setCategory(CategoryEnum.Art);
        category.setId(1);

        User seller = new User();
        seller.setCity("Oxford");
        seller.setCountry("GB");
        seller.setCreatedDate(LocalDate.of(1970, 1, 1));
        seller.setEmail("jane.doe@example.org");
        seller.setFirst_name("Jane");
        seller.setId(1);
        seller.setLast_name("Doe");
        seller.setNumber("42");
        seller.setPassword_hash("Password hash");
        seller.setProducts(new ArrayList<>());
        seller.setReceivedComments(new ArrayList<>());
        seller.setSendComments(new ArrayList<>());

        State state = new State();
        state.setId(1);
        state.setState(StateEnum.LIKE_NEW);

        Product product = new Product();
        product.setBuyerPayingDelivery(true);
        product.setCategory(category);
        product.setCreatedDate(LocalDate.of(1970, 1, 1));
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setName("Name");
        product.setPhotos(new ArrayList<>());
        product.setPrice(10.0f);
        product.setSeller(seller);
        product.setState(state);
        when(productService.getProductEntityById(anyInt())).thenReturn(product);
        assertThrows(Exception.class,
                () -> productPhotoService.addProductPhoto(ProductPhotoRequest.builder().path("Path").productId(1).build()));
        verify(productPhotoMapper).toEntity(Mockito.<ProductPhotoRequest>any(), Mockito.<Product>any());
        verify(productService).getProductEntityById(anyInt());
    }

    /**
     * Method under test: {@link ProductPhotoService#addProductPhoto(MultipartFile, int)}
     */
    @Test
    void testAddProductPhoto3() throws Exception {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            mockFiles.when(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
                    .thenReturn(1L);

            Category category = new Category();
            category.setCategory(CategoryEnum.Art);
            category.setId(1);

            User seller = new User();
            seller.setCity("Oxford");
            seller.setCountry("GB");
            seller.setCreatedDate(LocalDate.of(1970, 1, 1));
            seller.setEmail("jane.doe@example.org");
            seller.setFirst_name("Jane");
            seller.setId(1);
            seller.setLast_name("Doe");
            seller.setNumber("42");
            seller.setPassword_hash("Password hash");
            seller.setProducts(new ArrayList<>());
            seller.setReceivedComments(new ArrayList<>());
            seller.setSendComments(new ArrayList<>());

            State state = new State();
            state.setId(1);
            state.setState(StateEnum.LIKE_NEW);

            Product product = new Product();
            product.setBuyerPayingDelivery(true);
            product.setCategory(category);
            product.setCreatedDate(LocalDate.of(1970, 1, 1));
            product.setDescription("The characteristics of someone or something");
            product.setId(1);
            product.setName("Name");
            product.setPhotos(new ArrayList<>());
            product.setPrice(10.0f);
            product.setSeller(seller);
            product.setState(state);

            ProductPhoto productPhoto = new ProductPhoto();
            productPhoto.setId(1);
            productPhoto.setPath("Path");
            productPhoto.setProduct(product);
            when(productPhotoRepository.save(Mockito.<ProductPhoto>any())).thenReturn(productPhoto);

            Category category2 = new Category();
            category2.setCategory(CategoryEnum.Art);
            category2.setId(1);

            User seller2 = new User();
            seller2.setCity("Oxford");
            seller2.setCountry("GB");
            seller2.setCreatedDate(LocalDate.of(1970, 1, 1));
            seller2.setEmail("jane.doe@example.org");
            seller2.setFirst_name("Jane");
            seller2.setId(1);
            seller2.setLast_name("Doe");
            seller2.setNumber("42");
            seller2.setPassword_hash("Password hash");
            seller2.setProducts(new ArrayList<>());
            seller2.setReceivedComments(new ArrayList<>());
            seller2.setSendComments(new ArrayList<>());

            State state2 = new State();
            state2.setId(1);
            state2.setState(StateEnum.LIKE_NEW);

            Product product2 = new Product();
            product2.setBuyerPayingDelivery(true);
            product2.setCategory(category2);
            product2.setCreatedDate(LocalDate.of(1970, 1, 1));
            product2.setDescription("The characteristics of someone or something");
            product2.setId(1);
            product2.setName("Name");
            product2.setPhotos(new ArrayList<>());
            product2.setPrice(10.0f);
            product2.setSeller(seller2);
            product2.setState(state2);

            ProductPhoto productPhoto2 = new ProductPhoto();
            productPhoto2.setId(1);
            productPhoto2.setPath("Path");
            productPhoto2.setProduct(product2);
            when(productPhotoMapper.toEntity(Mockito.<ProductPhotoRequest>any(), Mockito.<Product>any()))
                    .thenReturn(productPhoto2);
            UserResponse seller3 = new UserResponse(1, "jane.doe@example.org", "42", "Jane", "Doe", "GB", "Oxford",
                    LocalDate.of(1970, 1, 1));

            StateResponse state3 = new StateResponse(1, StateEnum.LIKE_NEW, "MD");

            CategoryResponse category3 = new CategoryResponse(1, CategoryEnum.Art, "Category String");

            when(productPhotoMapper.toResponse(Mockito.<ProductPhoto>any())).thenReturn(new ProductPhotoResponse(1, "Path",
                    new ProductResponse(1, "Name", "The characteristics of someone or something", 10.0f, seller3, state3,
                            category3, true, LocalDate.of(1970, 1, 1))));

            Category category4 = new Category();
            category4.setCategory(CategoryEnum.Art);
            category4.setId(1);

            User seller4 = new User();
            seller4.setCity("Oxford");
            seller4.setCountry("GB");
            seller4.setCreatedDate(LocalDate.of(1970, 1, 1));
            seller4.setEmail("jane.doe@example.org");
            seller4.setFirst_name("Jane");
            seller4.setId(1);
            seller4.setLast_name("Doe");
            seller4.setNumber("42");
            seller4.setPassword_hash("Password hash");
            seller4.setProducts(new ArrayList<>());
            seller4.setReceivedComments(new ArrayList<>());
            seller4.setSendComments(new ArrayList<>());

            State state4 = new State();
            state4.setId(1);
            state4.setState(StateEnum.LIKE_NEW);

            Product product3 = new Product();
            product3.setBuyerPayingDelivery(true);
            product3.setCategory(category4);
            product3.setCreatedDate(LocalDate.of(1970, 1, 1));
            product3.setDescription("The characteristics of someone or something");
            product3.setId(1);
            product3.setName("Name");
            product3.setPhotos(new ArrayList<>());
            product3.setPrice(10.0f);
            product3.setSeller(seller4);
            product3.setState(state4);
            when(productService.getProductEntityById(anyInt())).thenReturn(product3);
            productPhotoService
                    .addProductPhoto(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), 1);
            verify(productPhotoMapper).toEntity(Mockito.<ProductPhotoRequest>any(), Mockito.<Product>any());
            verify(productPhotoMapper).toResponse(Mockito.<ProductPhoto>any());
            verify(productService).getProductEntityById(anyInt());
            mockFiles.verify(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
            verify(productPhotoRepository).save(Mockito.<ProductPhoto>any());
        }
    }

    /**
     * Method under test: {@link ProductPhotoService#deleteProductPhoto(int)}
     */
    @Test
    void testDeleteProductPhoto() {
        doNothing().when(productPhotoRepository).deleteById(Mockito.<Long>any());
        productPhotoService.deleteProductPhoto(1);
        verify(productPhotoRepository).deleteById(Mockito.<Long>any());
    }
}

