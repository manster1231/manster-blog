package com.manster.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.mapper.TagMapper;
import com.manster.service.BlogService;
import com.manster.service.TagService;
import com.manster.service.TypeService;
import com.manster.vo.BlogVO;
import com.manster.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/5/1
 **/
@Controller
public class IndexController {

    @Value("${project.pageSize}")
    private String pageSize;

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping({"","/"})
    public String index(@RequestParam(defaultValue = "1", name = "current") Integer current,
                        Model model){
        //博客分页信息
        IPage<BlogVO> page = blogService.listBlog(new Page<>(current, Long.parseLong(pageSize)));
        page.setTotal(blogService.countBlog());
        model.addAttribute("page",page);
        //侧边栏分类信息
        model.addAttribute("types",typeService.listTypeVO());
        //侧边栏标签信息
        model.addAttribute("tags",tagService.listTagVO());
        //侧边栏推荐博客
        model.addAttribute("blogs",blogService.listRecommendBlog());

        return "index";
    }

    //搜索
    @PostMapping("/search")
    public String search(@RequestParam(defaultValue = "1", name = "current") Integer current,
                         @RequestParam("query") String query,
                         Model model){
        //搜索结果分页信息
        IPage<BlogVO> page = blogService.listSearchBlog(new Page<>(current, Long.parseLong(pageSize)), query);
        page.setTotal(blogService.countSearchBlog(query));
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/footer/newblog")
    public String newblog(Model model){
        model.addAttribute("newblogs", blogService.getNewBlogs());
        return "blogfragments :: newbloglist";
    }

}
