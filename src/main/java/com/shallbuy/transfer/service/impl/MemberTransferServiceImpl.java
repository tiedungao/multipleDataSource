package com.shallbuy.transfer.service.impl;

import com.shallbuy.transfer.dao.newer.CreditsDao;
import com.shallbuy.transfer.dao.old.MemberDao;
import com.shallbuy.transfer.entity.CreditsEntity;
import com.shallbuy.transfer.entity.MemberEntity;
import com.shallbuy.transfer.service.MemberTransferService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v2.0
 * Description
 * @auther gaotiedun
 * Created Date 2020/1/10 0010 9:44
 * Updated Date      by
 */
@Service
public class MemberTransferServiceImpl implements MemberTransferService {

    private static final Log logger = LogFactory.getLog(MemberTransferServiceImpl.class);

    @Resource
    private MemberDao memberDao;

    @Resource
    private CreditsDao creditsDao;

    @Override
    @Transactional(value = "newTransactionManager")
    public void creditsTransfer() {
        List<MemberEntity> memberEntityList ;
        List<CreditsEntity> creditsEntityList;
        CreditsEntity creditsEntity;
        int limit = 20000;
        int start = 0;
        try {
            while (true) {
                creditsEntityList = new ArrayList<>();
                start = start + limit;
                memberEntityList = memberDao.selectMemberList(start,limit);
                if (null == memberEntityList || 0 == memberEntityList.size()) {
                    break;
                }else{
                    //如果存在数据,则对新库 进行数据插入
                    for (MemberEntity memberEntity:memberEntityList) {
                        creditsEntity = new CreditsEntity(memberEntity);
                        creditsEntityList.add(creditsEntity);
                    }
                }
                int size = creditsEntityList.size();
                if (0 != size) {
                    if (size != creditsDao.bathSaveCredits(creditsEntityList)) {
                        throw new RuntimeException("保存积分账户时发生异常");
                    }
                    logger.info("执行插入了："+size+"条数据");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
