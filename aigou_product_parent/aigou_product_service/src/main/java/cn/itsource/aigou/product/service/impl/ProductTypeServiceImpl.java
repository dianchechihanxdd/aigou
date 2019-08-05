package cn.itsource.aigou.product.service.impl;

import cn.itsource.aigou.product.domain.ProductType;
import cn.itsource.aigou.product.mapper.ProductTypeMapper;
import cn.itsource.aigou.product.service.IProductTypeService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author wbtest
 * @since 2019-08-01
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> treeData() {
        //要实现树装结构：
        //return treeDataRecursion(0L);
        return treeDataLoop();
    }

    /**
     * 1：查询出所有的数据
     * 2：组装父子结构
     * @return
     */
    public List<ProductType> treeDataLoop() {

        //返回的一级菜单
        List<ProductType> result = new ArrayList<>();

        //1：查询出所有的数据
        List<ProductType> allProductTypes = productTypeMapper.selectList(null);

        Map<Long,ProductType> map=new HashMap<>();
        //循环：把所有的对象，放到一个map：
        for (ProductType cur : allProductTypes) {
            map.put(cur.getId(),cur);
        }
        //2：组装父子结构
        for (ProductType current : allProductTypes) {
            //找一级菜单
            if(current.getPid()==0){
                result.add(current);
            }else{
                //你不是一级菜单，你就是儿子： 你是谁的儿子？？？ 你是你老子的儿子
                ProductType parent = null;//你老子
                /*
                 嵌套循环了：不嵌套
                for (ProductType cur : allProductTypes) {
                    if(cur.getId()==current.getPid()){
                        parent=cur;
                    }
                }*/
                parent = map.get(current.getPid());
               /* List<ProductType> children = parent.getChildren();//你老子的儿子
                children.add(current);//你自己是你老子的儿子*/
               parent.getChildren().add(current);
            }

        }


        return result;
    }

    /**
     * 递归：
     *   自己方法里调用自己，但是必须有一个出口：没有儿子就出去;
     *  好么：
     *   不好，因为每次都要发送sql，就要发送很多的sql：
     *     要耗时；数据库的服务器要承受很多的访问量，压力大。
     *   ====》原因是发送了很多sql，我优化就少发送，至少发送1条。
     * @return
     */
    public List<ProductType> treeDataRecursion(Long pid) {
        //所有的一级菜单
        List<ProductType> allChildren = getAllChildren(pid);
        //出口：没有儿子
        if(allChildren==null||allChildren.size()==0){
            return  null;
        }
        //遍历：找当前遍历对象的儿子：
        for (ProductType current : allChildren) {
            //找当前对象的儿子
            List<ProductType> productTypes = treeDataRecursion(current.getId());
            current.setChildren(productTypes);
        }
        return allChildren;
    }

    /**
     * 查询数据的pid=pid的：
     *  // select * from t_product_type where pid = 2
     * @param pid
     * @return
     */
    public List<ProductType> getAllChildren(Long pid) {
        Wrapper<ProductType> wrapper = new EntityWrapper<>();
        wrapper.eq("pid",pid);
        return  productTypeMapper.selectList(wrapper);
    }
}
