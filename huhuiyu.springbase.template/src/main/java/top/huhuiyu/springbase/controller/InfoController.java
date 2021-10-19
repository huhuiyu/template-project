package top.huhuiyu.springbase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbase.entity.Info;

/**
 * 演示控制器
 * 
 * @author 胡辉煜
 *
 */
@RestController
public class InfoController {

  private static final Logger log = LoggerFactory.getLogger(InfoController.class);

  // 测试用url: http://127.0.0.1:20000/hello?name=%E5%BC%A0%E4%B8%89&age=10
  @GetMapping("/hello")
  public Info hello(Info info) {
    log.debug("获取的请求信息:{}", info);
    return info;
  }
}
