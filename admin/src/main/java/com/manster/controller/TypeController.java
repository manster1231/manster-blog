package com.manster.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.emnu.Message;
import com.manster.pojo.Type;
import com.manster.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @Author manster
 * @Date 2021/4/24
 **/
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Value("${project.pageSize}")
    private String pageSize;
    @Autowired
    private TypeService typeService;

    /**
     * 对分类信息进行分页
     * @param current 当前页
     * @param model
     * @return
     */
    @GetMapping("/types")
    public String types(@RequestParam(defaultValue = "1", name = "current") Integer current,
                        Model model){
        //获取分页信息
        IPage<Type> page = typeService.listType(new Page<>(current, Long.parseLong(pageSize)));
        model.addAttribute("page", page);
        return "types";
    }

    /**
     * 跳转到分类输入页
     * @return
     */
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type", new Type());
        return "types-input";
    }

    /**
     * 携带该分类跳转到编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/types/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "types-input";
    }

    /**
     * 保存分类
     * 如果没有id则为新增，id存在则为修改
     * @param type 前端传来的type
     * @return 成功返回列表页面，失败返回编辑页面
     */
    @PostMapping("/types/save")
    public String save(Type type, BindingResult result, RedirectAttributes attributes){
        Type t = typeService.getTypeByName(type.getName());
        if(t != null){
            result.rejectValue("name", "nameError", "该分类已存在，不可重复添加！");
            return "types-input";
        }
        if(!StringUtils.hasText(type.getName())) {
            result.rejectValue("name", "nameError", "请输入分类名称！");
            return "types-input";
        }
        int i;
        if(type.getId() != null){//有id则为修改
            i = typeService.updateType(type);
            if(i < 1){
                attributes.addFlashAttribute("message", Message.FAILED_EDIT);
            } else {
                attributes.addFlashAttribute("message",Message.SUCCESS_EDIT);
            }
        } else {//没有id则为新增
            i = typeService.saveType(type);
            if(i < 1){
                attributes.addFlashAttribute("message",Message.FAILED_ADD);
            } else {
                attributes.addFlashAttribute("message",Message.SUCCESS_ADD);
            }
        }

        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        int i = typeService.deleteType(id);
        if(i < 1){
            attributes.addFlashAttribute("message","删除失败");
        } else {
            attributes.addFlashAttribute("message","删除成功");
        }
        return "redirect:/admin/types";
    }

}
