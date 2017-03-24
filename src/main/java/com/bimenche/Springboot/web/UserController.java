/**
 * 
 */
package com.bimenche.Springboot.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bimenche.Springboot.model.User;


/** 
 * @author  作者:闭门车 E-mail: hao_3602g@163.com
 * @date 创建时间：2017年3月23日 下午7:04:39 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@RestController
@RequestMapping(value="/users")     // 这里配置使下面的映射都在/users下，参照springmvc
public class UserController {

	static Map<Integer, User> users = new HashMap<Integer, User>(32);
	//初始化一条数据
	static{
		User user=new User();
		user.setAge(21);
		user.setId(1);
		user.setName("超级用户");
		users.put(user.getAge(), user);
	}
	
	   @RequestMapping(value="/", method=RequestMethod.GET)
	    public List<User> getUserList() {
	        // 处理"/users/"的GET请求，用来获取用户列表
	        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
	        List<User> r = new ArrayList<User>(users.values());
	        System.out.println("get user");
	        return r;
	    }
	   @RequestMapping(value="/", method=RequestMethod.POST)
	    public String postUser(@ModelAttribute User user) {
	        // 处理"/users/"的POST请求，用来创建User
	        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
	        users.put(user.getId(), user);
	        return "success";
	    }

	    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	    public User getUser(@PathVariable Long id) {
	        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
	        // url中的id可通过@PathVariable绑定到函数的参数中
	        return users.get(id);
	    }
        /**
         * 
          * @Title: putUser 
          * @Description: 请求地址/users/{id} PUT请求，用来更新User信息
          * @param @param id
          * @param @param user
          * @param @return    设定文件 
          * @return String    返回类型 
          * @throws 
          * @author 闭门车
         */
	    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
	    public String putUser(@PathVariable Integer id, @ModelAttribute User user) {
	        // 处理"/users/{id}"的PUT请求，用来更新User信息
	        User u = users.get(id);
	        u.setName(user.getName());
	        u.setAge(user.getAge());
	        users.put(id, u);
	        return "success";
	    }
        /**
         * 请求地址 /users/{id}" DELETE请求，用来删除User
         */
	    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	    public String deleteUser(@PathVariable Long id) {
	        
	        users.remove(id);
	        return "success";
	    }
}

