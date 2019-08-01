package cn.itsource.aigou.product.service;

import cn.itsource.aigou.product.domain.Brand;
import cn.itsource.aigou.product.query.BrandQuery;
import cn.itsource.aigou.util.PageList;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author wbtest
 * @since 2019-05-09
 */
public interface IBrandService extends IService<Brand> {

    PageList<Brand> queryPage(BrandQuery brandQuery);

}
