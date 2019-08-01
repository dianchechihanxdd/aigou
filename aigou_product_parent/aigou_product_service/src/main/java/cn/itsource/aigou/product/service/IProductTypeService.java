package cn.itsource.aigou.product.service;

import cn.itsource.aigou.product.domain.ProductType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author wbtest
 * @since 2019-05-09
 */
public interface IProductTypeService extends IService<ProductType> {

    /**
     * 获取树状结构
     * @return
     */
    List<ProductType> treeData();
}
