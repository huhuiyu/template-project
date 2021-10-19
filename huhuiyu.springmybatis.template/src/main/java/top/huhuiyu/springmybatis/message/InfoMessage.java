package top.huhuiyu.springmybatis.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import top.huhuiyu.springmybatis.base.BaseMessage;
import top.huhuiyu.springmybatis.base.PageBean;
import top.huhuiyu.springmybatis.entity.TbSpringbootDemoInfo;

/**
 * 查询信息应答
 * 
 * @author 胡辉煜
 *
 */
@ApiModel(value = "查询应答信息", description = "查询应答信息")
public class InfoMessage extends BaseMessage {
  private static final long serialVersionUID = -7353555983389608815L;
  private List<TbSpringbootDemoInfo> list;
  private PageBean page = new PageBean();

  public InfoMessage() {
  }

  public List<TbSpringbootDemoInfo> getList() {
    return list;
  }

  public void setList(List<TbSpringbootDemoInfo> list) {
    this.list = list;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

}
