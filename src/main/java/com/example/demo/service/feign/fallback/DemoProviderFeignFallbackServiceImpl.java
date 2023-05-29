package com.example.demo.service.feign.fallback;

import com.example.demo.entity.User;
import com.example.demo.service.feign.DemoProviderFeignService;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoProviderFeignFallbackServiceImpl implements DemoProviderFeignService {
    @Override
    public String getMyName() {
        log.info("call demo-provider getMyName fall");
        return null;
    }

    @Override
    public String insertUser(User user) {
        //feign调用接口fallback后可手动调用全局事务回滚
        try {
            String xid = RootContext.getXID();
            GlobalTransactionContext.reload(xid).rollback();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
        log.error("call demo-provider insert user error");
        return null;
    }
}
