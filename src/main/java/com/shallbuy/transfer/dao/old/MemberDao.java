package com.shallbuy.transfer.dao.old;

import com.shallbuy.transfer.entity.MemberEntity;
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
public interface MemberDao {

    List<MemberEntity> selectMemberList(int start,int limit);

}
