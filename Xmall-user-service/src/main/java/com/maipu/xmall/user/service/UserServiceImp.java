package com.maipu.xmall.user.service;
import com.maipu.Xmall.bean.UmsMember;
import com.maipu.Xmall.service.UserService;
import com.maipu.xmall.user.dao.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.alibaba.dubbo.config.annotation.Service;
/**
 * @title: 用户服务接口
 * @description: 用户服务接口的实现
 * @author: Asing
 * @date: 2020-04-04 16:22:05
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UmsMemberMapper umsMemberMapper;
    @Override
    public List<UmsMember> getAllMembers() {
        List<UmsMember> umsMember = umsMemberMapper.selectAll();
        return umsMember;
    }
}
