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

//   private IAccountDao accountDao = new AccountDaoImpl();
/**
 * 此部分存在耦合，所以建立ui文件
 */
   
   /**
    * 把这部分代码删掉，就会产生错误
    */
   
    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

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
