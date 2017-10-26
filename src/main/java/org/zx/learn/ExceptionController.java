package org.zx.learn;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by xiang zeng on 2017/10/26.
 *
 * @author xiang zeng
 */
@Controller
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler
    private void handlerInternalException(HttpServletResponse response) throws IOException {
        response.sendRedirect("/static/error500.html");
    }
}
