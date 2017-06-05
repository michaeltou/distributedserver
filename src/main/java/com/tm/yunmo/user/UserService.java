package com.tm.yunmo.user;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daoying on 2017/3/13.
 */

@RestController
@Transactional
public class UserService {




    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Person person;

    @RequestMapping("/testbean")
    public String testBean(){

        person.sayHello();
        return "ok.";
    }

    //http://localhost:8080/queryuser?fullname=michael
    @RequestMapping("/queryuser")
    public String queryUser(@RequestParam("fullname")String name){

    User user = userDAO.findUserByName(name);

    String result = user.getId()+ user.getName()+user.getAge();
    return result;
    }

   /*http://localhost:8080/insertuser?id=3&name=dy&age=23 */
    @RequestMapping("/insertuser")
    public String insertUser(@RequestParam("id")int id, @RequestParam("name")String name, @RequestParam("age")int  age){

        int opResult  = userDAO.insertUser(id,name,age);

        String result = "insert result:"+opResult;
        return result;
    }

    /* http://localhost:8080/updateuser?id=3&name=daoying2&age=33 */
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "用户nage", required = true, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "用户的age", required = true, dataType = "Long")
    })
    @RequestMapping("/updateuser")
    public String updateUser(@RequestParam("id")int id, @RequestParam("name")String name, @RequestParam("age")int  age){
        int opResult  = userDAO.updateUser(id,name,age);
        String result = "update result:"+opResult;
        return result;
    }

   /* http://localhost:8080/deleteuser?id=3 */
   @ApiOperation(value="删除用户", notes="根据用户id，删除用户")
   @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping("/deleteuser")
    public String deleteUser(@RequestParam("id")int id){
        int opResult  = userDAO.deleteUser(id);
        String result = "delete result:"+opResult;
        return result;
    }










}
