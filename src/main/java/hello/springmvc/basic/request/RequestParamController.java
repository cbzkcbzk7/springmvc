package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 * packageName    : hello.springmvc.basic.request
 * fileName       : RequestParamController
 * author         : Sora
 * date           : 2024-05-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-28        Sora       최초 생성
 */
@Slf4j
@Controller
public class RequestParamController {


    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}",username);
        log.info("age={}",age);

        response.getWriter().write("ok");

    }

    @ResponseBody   // @RestController와 같음
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){

        log.info("memberName={}",memberName);
        log.info("memberAge={}",memberAge);

        return "ok";
    }

    @ResponseBody   // @RestController와 같음
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){

        log.info("username={}",username);
        log.info("age={}",age);

        return "ok";
    }

    /**
     * 매개 변수명과 요청 파라미터 변수명이 동일하면
     * @RequestParam 도 생략가능함
     * - 직관적이지 않을 수 있으니 너무 생략하면
     *   과한다는 강사의 직관적인 생각이 있음
     */
    @ResponseBody   // @RestController와 같음
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){

        log.info("username={}",username);
        log.info("age={}",age);

        return "ok";
    }

    /*
     * 필수 파라미터
     * required = true ( default )
     * 요청 파라미터값이 꼭 들어와야함
     *
     * int 값 required = false 처리 시 null값을 받을 수 있는 Integer로 처리
     */
    @ResponseBody   // @RestController와 같음
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age){

        log.info("username={}",username);
        log.info("age={}",age);

        return "ok";
    }

    /*
     * defaultValue : 기본값
     * "" 빈 문자열도 처리해준다
     */
    @ResponseBody   // @RestController와 같음
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age){

        log.info("username={}",username);
        log.info("age={}",age);

        return "ok";
    }

    @ResponseBody   // @RestController와 같음
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){

        log.info("username={}, age={}",paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    /*
     * @ModelAttribute :
     * 스프링에서 필요한 객체를 만들고 요청 파라미터값을 객체에 넣어주는 것을 자동화으로 해줌
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(), helloData.getUsername());
        log.info("hellData={}", helloData);

        return "ok";
    }

    /*
     * @ModelAttribute 생략 가능
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(), helloData.getUsername());
        log.info("hellData={}", helloData);

        return "ok";
    }

}
