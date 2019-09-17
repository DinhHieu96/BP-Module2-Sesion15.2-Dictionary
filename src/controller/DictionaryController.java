package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    static Map<String, String> dic = new HashMap<>();

    static {
        dic.put("hello", "xin chào");
        dic.put("good bye", "tạm biệt");
        dic.put("book", "quyển sách");
        dic.put("ruller", "thước");
    }

    @GetMapping("translate")
    public String translate(@RequestParam String word, Model model) {
        model.addAttribute("word", word);
        if (dic.containsKey(word)) {
            model.addAttribute("translate", dic.get(word));
        } else {
            model.addAttribute("translate", "Not found");
        }
        return "index";
    }
}
