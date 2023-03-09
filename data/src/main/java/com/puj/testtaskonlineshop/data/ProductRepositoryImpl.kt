package com.puj.testtaskonlineshop.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.puj.testtaskonlineshop.domain.ProductRepository
import com.puj.testtaskonlineshop.domain.models.Product
import com.puj.testtaskonlineshop.data.mappers.ProductMapper
import com.puj.testtaskonlineshop.data.network.models.ProductDto
import com.puj.testtaskonlineshop.data.network.product.ProductRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val dataSource: ProductRemoteDataSource,
    private val mapper: ProductMapper
): ProductRepository {

    private val product = MutableLiveData<ProductDto>()

    override fun getProduct(): LiveData<Product> {
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            val response = dataSource.getProduct()
            product.postValue(response)
        }

        return Transformations.map(product){
            mapper.mapProductDtoToProduct(it)
        }
    }
}