package top.huhuiyu.springmybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.springmybatis.entity.TbSpringbootDemoInfo;

/**
 * tb_springboot_demo_info表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbSpringbootDemoInfoDAO {
  /**
   * 查询全部tb_springboot_demo_info
   * 
   * @param tbSpringbootDemoInfo 查询条件
   * 
   * @return tb_springboot_demo_info的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbSpringbootDemoInfo> queryAll(TbSpringbootDemoInfo tbSpringbootDemoInfo) throws Exception;

  /**
   * 添加tb_springboot_demo_info信息
   *
   * @param tbSpringbootDemoInfo tbSpringbootDemoInfo信息
   * 
   * @return 添加tbSpringbootDemoInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbSpringbootDemoInfo tbSpringbootDemoInfo) throws Exception;

  /**
   * 修改tb_springboot_demo_info信息
   *
   * @param tbSpringbootDemoInfo tbSpringbootDemoInfo信息
   * 
   * @return 修改tbSpringbootDemoInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbSpringbootDemoInfo tbSpringbootDemoInfo) throws Exception;

  /**
   * 删除tb_springboot_demo_info信息
   *
   * @param tbSpringbootDemoInfo tbSpringbootDemoInfo信息
   * 
   * @return 删除tbSpringbootDemoInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbSpringbootDemoInfo tbSpringbootDemoInfo) throws Exception;

}