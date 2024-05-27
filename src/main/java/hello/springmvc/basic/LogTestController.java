package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : hello.springmvc.basic
 * fileName       : LogTestController
 * author         : Sora
 * date           : 2024-05-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-27        Sora       최초 생성
 */
@RestController
@Slf4j
public class LogTestController {
      // @Slf4j 로 변경 가능
//    private final Logger log = LoggerFactory.getLogger(getClass());


    /*
     * application.properties 에서 레벨 정할 수 있음 : 정한 레벨과 그 하위 레벨만 출력
     * 개발 서버는 debug, 운영 서버는 info 출력
     * 로그 찍을 때 형식 지키기 : 자바의 형식대로 + 사용하면 에러는 안나지만,
       자바는 문법 상 연산을 먼저하고 가지고 있기때문에 쓸모없는 연산이 이루어짐
       (ex: info로 설정해도 trace, debug에 관한 연산을 함 - 리소스 사용)
     * 로그는 설정하면 파일로 만들 수 있음
     */
    @RequestMapping("/log-test")
    public String logTest(){
        String name ="Spring";

        System.out.println("name = " + name); // 과거 로그 사용법 : 운영서버에 로그가 전부 남겨지면 서버 폭발할 수 있음

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
