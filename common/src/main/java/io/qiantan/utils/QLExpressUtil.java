package io.qiantan.utils;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * @author yujiacheng
 * @date 2019/8/55:08 PM
 */
public class QLExpressUtil {

    private ExpressRunner getRunner() {
        return new ExpressRunner();
    }

    private DefaultContext getContext() {
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
        return context;
    }

    private void execute(String bash) throws Exception {
        ExpressRunner runner = this.getRunner();
        DefaultContext context = this.getContext();
        Object r = runner.execute(bash, context, null, true, false);
        System.out.println(r);
    }

    public static void main(String[] args) throws Exception {
        QLExpressUtil expressUtil = new QLExpressUtil();
        expressUtil.execute("a + b * c");
    }
}
