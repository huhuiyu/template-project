package top.huhuiyu.springmybatis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.huhuiyu.springmybatis.base.BaseMessage;
import top.huhuiyu.springmybatis.base.PageBean;
import top.huhuiyu.springmybatis.dao.TbSpringbootDemoInfoDAO;
import top.huhuiyu.springmybatis.entity.TbSpringbootDemoInfo;
import top.huhuiyu.springmybatis.message.InfoMessage;

/**
 * 信息演示控制器
 * 
 * @author 胡辉煜
 *
 */
@Api(tags = { "信息演示接口" })
@RestController
@RequestMapping("/info")
public class InfoController {

  private static final Logger log = LoggerFactory.getLogger(InfoController.class);

  @Autowired
  private TbSpringbootDemoInfoDAO infoDAO;

  @PostMapping("/add")
  @ApiOperation(value = "添加信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "infoKey", value = "信息键值", paramType = "query", required = true),
      @ApiImplicitParam(name = "info", value = "信息值", paramType = "query", required = true) })
  public BaseMessage add(TbSpringbootDemoInfo info) {
    log.debug("请求参数：{}", info);
    BaseMessage message = new BaseMessage();
    try {
      infoDAO.add(info);
      return message.setSuccessInfo("添加成功");
    } catch (Exception ex) {
      return message.setFailInfo(ex.getMessage());
    }
  }

  @PostMapping("/update")
  @ApiOperation(value = "修改信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "iid", value = "要修改的信息编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "infoKey", value = "信息键值", paramType = "query", required = true), @ApiImplicitParam(name = "info", value = "信息值", paramType = "query", required = true) })
  public BaseMessage update(TbSpringbootDemoInfo info) {
    log.debug("请求参数：{}", info);
    BaseMessage message = new BaseMessage();
    try {
      infoDAO.update(info);
      return message.setSuccessInfo("修改成功");
    } catch (Exception ex) {
      return message.setFailInfo(ex.getMessage());
    }
  }

  @PostMapping("/delete")
  @ApiOperation(value = "删除信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "iid", value = "要删除的信息编号", paramType = "query", required = true) })
  public BaseMessage delete(TbSpringbootDemoInfo info) {
    log.debug("请求参数：{}", info);
    BaseMessage message = new BaseMessage();
    try {
      infoDAO.delete(info);
      return message.setSuccessInfo("删除成功");
    } catch (Exception ex) {
      return message.setFailInfo(ex.getMessage());
    }
  }

  @PostMapping("/query")
  @ApiOperation(value = "查询全部")
  @ApiImplicitParams({ @ApiImplicitParam(name = "pageNumber", value = "分页页码", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "分页大小", paramType = "query"),
      @ApiImplicitParam(name = "infoKey", value = "信息键值模糊查询", paramType = "query"), @ApiImplicitParam(name = "info", value = "信息值模糊查询", paramType = "query") })
  public InfoMessage query(TbSpringbootDemoInfo info, PageBean page) {
    log.debug("请求参数：info-{},page-{}", info, page);
    InfoMessage message = new InfoMessage();
    try {
      // 模糊查询条件
      if (StringUtils.hasText(info.getInfoKey())) {
        info.setInfoKey(String.format("%%%s%%", info.getInfoKey()));
      }
      if (StringUtils.hasText(info.getInfo())) {
        info.setInfo(String.format("%%%s%%", info.getInfo()));
      }
      // 分页查询
      PageHelper.startPage(page.getPageNumber(), page.getPageSize());
      List<TbSpringbootDemoInfo> list = infoDAO.queryAll(info);
      PageInfo<?> pageInfo = new PageInfo<>(list);
      page.setPageInfo(pageInfo);
      // 应答结果
      message.setPage(page);
      message.setList(list);
      message.setSuccessInfo("");
      return message;
    } catch (Exception ex) {
      message.setFailInfo(ex.getMessage());
      return message;
    }
  }

}
