package com.multi.pratice.multipratice.springbasic.filter.filterr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.filter.filterr
 * fileName : GlobalFilter
 * author : taeil
 * date : 2023/02/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/28        taeil                   최초생성
 */
@Slf4j
// @Component

// -> SpringBootApplication에 @ServletComponentScan을 추가, 지정한 url patterns로 들어오는 요청에 대해 필터 적용
@WebFilter(urlPatterns = "/api/test/*")
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        // 선처리
        ContentCachingRequestWrapper httpServletRequest
                = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse
                = new ContentCachingResponseWrapper ((HttpServletResponse) response);


        chain.doFilter(httpServletRequest, httpServletResponse);


        String url = httpServletRequest.getRequestURI();
        // 후처리
        // 요청 정보 --> 읽어오는것은 커서 단위로 읽어옴.. -> getContentAsByteArray
        String reqContent = new String(httpServletRequest.getContentAsByteArray());

        log.info("request url : {}, requestBody : {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        // 커서 단위로 한번 다 읽어온 후, 커서가 제일 최하단으로 내려가있기 때문에 response Body에 데이터를 담아줄수없음 --> 복사해서 넣어주자
        httpServletResponse.copyBodyToResponse();

        log.info("response status : {}, responseBody : {}", httpStatus, resContent);
    }
}