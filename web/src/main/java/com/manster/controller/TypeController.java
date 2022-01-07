package com.manster.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.service.BlogService;
import com.manster.service.TypeService;
import com.manster.vo.BlogVO;
import com.manster.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/5/7
 **/
@Controller
public class TypeController {

    @Value("${project.pageSize}")
    private String pageSize;

    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PathVariable Long id,
                        @RequestParam(defaultValue = "1", name = "current") Integer current,
                        Model model){

        List<TypeVO> types = typeService.listTypeVO();
        //从导航栏跳过来的,就默认显示第一个
        if(id == -1){
            if(types.size()>0){
                id = types.get(0).getId();
            }
        }
        model.addAttribute("types", types);
        IPage<BlogVO> page = blogService.listBlogByType(new Page<>(current, Long.parseLong(pageSize)), id);
        page.setTotal(blogService.countBlogByType(id));
        model.addAttribute("page", page);
        model.addAttribute("activeId", id);

        return "types";
    }

}
