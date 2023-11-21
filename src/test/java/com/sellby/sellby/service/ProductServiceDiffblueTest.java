package com.sellby.sellby.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sellby.sellby.mapper.ProductMapper;
import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.enums.CategoryEnum;
import com.sellby.sellby.model.enums.StateEnum;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.response.CategoryResponse;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.model.response.StateResponse;
import com.sellby.sellby.model.response.UserResponse;
import com.sellby.sellby.repository.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(MockitoExtension.class)
class ProductServiceDiffblueTest {
    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        List<ProductResponse> actualAllProducts = productService.getAllProducts();
        verify(productRepository).findAll();
        assertTrue(actualAllProducts.isEmpty());
    }

    /**
     * Method under test: {@link ProductService#getProductById(int)}
     */
    @Test
    void testGetProductById() throws Exception {
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
        UserResponse seller2 = new UserResponse(1, "jane.doe@example.org", "42", "Jane", "Doe", "GB", "Oxford",
                LocalDate.of(1970, 1, 1));

        StateResponse state2 = new StateResponse(1, StateEnum.LIKE_NEW, "MD");

        CategoryResponse category2 = new CategoryResponse(1, CategoryEnum.Art, "Category String");

        ProductResponse productResponse = new ProductResponse(1, "Name", "The characteristics of someone or something",
                10.0f, seller2, state2, category2, true, LocalDate.of(1970, 1, 1));

        when(productMapper.toResponse(Mockito.<Product>any())).thenReturn(productResponse);
        ProductResponse actualProductById = productService.getProductById(1);
        verify(productMapper).toResponse(Mockito.<Product>any());
        verify(productRepository).findById(Mockito.<Long>any());
        assertSame(productResponse, actualProductById);
    }

    /**
     * Method under test: {@link ProductService#getProductEntityById(int)}
     */
    @Test
    void testGetProductEntityById() {
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
        Product actualProductEntityById = productService.getProductEntityById(1);
        verify(productRepository).findById(Mockito.<Long>any());
        assertSame(product, actualProductEntityById);
    }

    /**
     * Method under test: {@link ProductService#addProduct(ProductRequest)}
     */
    @Test
    void testAddProduct() {
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
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);

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
        when(productMapper.toEntity(Mockito.<ProductRequest>any())).thenReturn(product2);
        UserResponse seller3 = new UserResponse(1, "jane.doe@example.org", "42", "Jane", "Doe", "GB", "Oxford",
                LocalDate.of(1970, 1, 1));

        StateResponse state3 = new StateResponse(1, StateEnum.LIKE_NEW, "MD");

        CategoryResponse category3 = new CategoryResponse(1, CategoryEnum.Art, "Category String");

        ProductResponse productResponse = new ProductResponse(1, "Name", "The characteristics of someone or something",
                10.0f, seller3, state3, category3, true, LocalDate.of(1970, 1, 1));

        when(productMapper.toResponse(Mockito.<Product>any())).thenReturn(productResponse);
        ProductResponse actualAddProductResult = productService
                .addProduct(new ProductRequest("Name", "The characteristics of someone or something", 10.0f, 1, 1, 1, true));
        verify(productMapper).toEntity(Mockito.<ProductRequest>any());
        verify(productMapper).toResponse(Mockito.<Product>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertSame(productResponse, actualAddProductResult);
    }

    /**
     * Method under test: {@link ProductService#deleteProduct(int)}
     */
    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(Mockito.<Long>any());
        productService.deleteProduct(1);
        verify(productRepository).deleteById(Mockito.<Long>any());
    }
}

