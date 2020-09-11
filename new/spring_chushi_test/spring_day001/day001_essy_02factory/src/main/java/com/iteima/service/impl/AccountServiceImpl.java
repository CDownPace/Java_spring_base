package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**
 * 账户的业务层实现类
 * 
 * 业务层调用持久层
 */
public class AccountServiceImpl implements IAccountService {

   private IAccountDao accountDao = new AccountDaoImpl();

   // private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

//    private int i = 1;

//    public void  saveAccount(){
//        int i = 1;
//        accountDao.saveAccount();
//        System.out.println(i);
//        i++;
//    }
   public void saveAccount() {
	   accountDao.saveAccount();
   }
}
