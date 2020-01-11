package com.shallbuy.transfer.service.impl;

import com.shallbuy.transfer.service.MemberTransferService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class MemberTransferServiceImplTest {

    @Resource
    private MemberTransferService memberTransferService;

    @Test
    void creditsTransfer() {
        memberTransferService.creditsTransfer();
    }
}