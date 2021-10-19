package top.huhuiyu.springmybatis.base;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基本应答信息
 * 
 * @author 胡辉煜
 *
 */
@ApiModel(value = "基本应答信息", description = "基本应答信息")
public class BaseMessage implements Serializable {

  private static final long serialVersionUID = 5469796510648122664L;
  public static final int OK = 200;
  public static final int ERROR = 500;

  /**
   * code:服务器应答代码，200为正确，500为错误，其它为自定义，默认500
   */
  @ApiModelProperty(value = "服务器应答代码")
  private int code = ERROR;
  /**
   * message：服务器应答信息，默认为空
   */
  @ApiModelProperty(value = "服务器应答信息")
  private String message = "";

  /**
   * success：服务器是否正确应答，默认为false
   */
  @ApiModelProperty(value = "服务器是否正确应答")
  private boolean success = false;

  public BaseMessage() {
  }

  /**
   * 设置正确应答信息
   * 
   * @param message 信息内容
   * 
   * @return 应答对象
   */
  public BaseMessage setSuccessInfo(String message) {
    this.code = OK;
    this.success = true;
    this.message = message;
    return this;
  }

  /**
   * 设置失败应答信息
   * 
   * @param message 信息内容
   * 
   * @return 应答对象
   */
  public BaseMessage setFailInfo(String message) {
    this.code = ERROR;
    this.success = false;
    this.message = message;
    return this;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

}
