package top.huhuiyu.springmybatis.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * tb_springboot_demo_info表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "演示信息类", description = "演示信息类")
public class TbSpringbootDemoInfo implements Serializable {

  private static final long serialVersionUID = -5948401049070195640L;

  @ApiModelProperty(value = "主键")
  @ApiParam(hidden = true)
  private java.lang.Integer iid;
  @ApiModelProperty(value = "信息键值")
  @ApiParam(hidden = true)
  private java.lang.String infoKey;
  @ApiModelProperty(value = "信息值")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbSpringbootDemoInfo() {
  }

  public java.lang.Integer getIid() {
    return iid;
  }

  public void setIid(java.lang.Integer iid) {
    this.iid = iid;
  }

  public java.lang.String getInfoKey() {
    return infoKey;
  }

  public void setInfoKey(java.lang.String infoKey) {
    this.infoKey = infoKey;
  }

  public java.lang.String getInfo() {
    return info;
  }

  public void setInfo(java.lang.String info) {
    this.info = info;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  @Override
  public String toString() {
    return "TbSpringbootDemoInfo [iid=" + iid + ", infoKey=" + infoKey + ", info=" + info + ", lastupdate=" + lastupdate + "]";
  }

}