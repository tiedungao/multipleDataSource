package com.shallbuy.transfer.dao.newer;

import com.shallbuy.transfer.entity.CreditsEntity;
import com.shallbuy.transfer.entity.MemberEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version v2.0
 * Description
 * @auther gaotiedun
 * Created Date 2020/1/10 0010 9:53
 * Updated Date      by
 */
@Repository
public interface CreditsDao {

    int bathSaveCredits(@Param("creditsEntityList") List<CreditsEntity> creditsEntityList);

}
