package com.springapp.mvc.controller;

import com.springapp.mvc.dto.StudentDto;
import com.springapp.mvc.repository.AutoFillRepository;
import com.springapp.mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by moiseencoo on 13.03.2017.
 */
@Controller
@RequestMapping(value = "/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AutoFillRepository autoFillRepository;



    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        ModelAndView m = new ModelAndView("studentPage");
        List<StudentDto> students = studentRepository.getAllStudents();
        m.addObject("studentsList", students);
        m.addObject("studentDto", new StudentDto());
        m.addObject("change", false);
        return m;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("studentDto") StudentDto stutentDto) {
        // System.out.println(stutentDto.toString());
        studentRepository.addStudents(stutentDto);
        return "redirect:/";
    }


    @RequestMapping(value = "/delete2/{id}", method = RequestMethod.GET)
    public String delete2(@PathVariable("id") Long id) {
        studentRepository.deleteStudent(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") Long id) {
        ModelAndView m = new ModelAndView("studentPage");
        List<StudentDto> students = studentRepository.getAllStudents();
        StudentDto studentDto = new StudentDto();
        for (StudentDto student : students) {
            if (student.getIdStudent() == id) {
                studentDto.setIdStudent(student.getIdStudent());
                studentDto.setName(student.getName());
                studentDto.setSurname(student.getSurname());
                studentDto.setAge(student.getAge());
                studentDto.setAdmin(student.isAdmin());

            }
        }

        m.addObject("studentsList", students);
        m.addObject("studentDto", studentDto);
        m.addObject("change", true);

        return m;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute("studentDto") StudentDto stutentDto) {
        this.studentRepository.update(stutentDto);
        return "redirect:/";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(String name) {
        ModelAndView m = new ModelAndView("searchResultPage");
        System.out.println(name);
        List<StudentDto> studentDtoList;
        studentDtoList = studentRepository.searchbyName(name);
        System.out.println(studentDtoList);
        m.addObject("list", studentDtoList);
        m.addObject("checker", studentDtoList.isEmpty());
        m.addObject("name", name);
        return m;
    }


    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String backToMain(String name) {
        return "redirect:/";
    }

    @RequestMapping(value = "/autoFill", method = RequestMethod.GET)
    public String autoFill(String name) {
        autoFillRepository.addStudents1();
        return "redirect:/";
    }


    @RequestMapping(value="/list")
    public ModelAndView listOfUsers(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("studentPage");

        List<StudentDto> users = studentRepository.getAllStudents();
        PagedListHolder<StudentDto> pagedListHolder = new PagedListHolder<StudentDto>(users);
        pagedListHolder.setPageSize(5);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

        modelAndView.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("users", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("users", pagedListHolder.getPageList());
        }

        return modelAndView;
    }


}
