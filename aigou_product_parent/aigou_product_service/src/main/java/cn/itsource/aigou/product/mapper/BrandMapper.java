package cn.itsource.aigou.product.mapper;

import cn.itsource.aigou.product.domain.Brand;
import cn.itsource.aigou.product.query.BrandQuery;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author wbtest
 * @since 2019-08-01
 */
public interface BrandMapper extends BaseMapper<Brand> {

    /**
     * 分页查询的总条数
     * @param brandQuery 查询条件
     * @return
     */
    long queryPageCount(BrandQuery brandQuery);


    /**
     * 分页查询的当前页的数据
     * @param brandQuery 查询条件
     * @return
     */
    List<Brand> queryPageList(BrandQuery brandQuery);

}
