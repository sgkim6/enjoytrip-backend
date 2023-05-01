package com.attraction.controller;

import com.attraction.vo.Attraction;
import com.attraction.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttractionController {
    @Autowired
    AttractionService service;
    @GetMapping(value =  "/attractions" )
    public ResponseEntity<List<Attraction>> selectAll()throws Exception {// Map(key, value)
        List<Attraction> list = service.selectAll();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }
    @GetMapping(value = "/attractions/{content_id}")
    public ResponseEntity<Attraction> read(@PathVariable String content_id)throws Exception  {

        return ResponseEntity.status(HttpStatus.OK).body(service.selectOne(content_id));
    }

//    @PostMapping(value = "/customers") // db에 입력
//    @ApiOperation(notes = "객체를 삽입 합니다.", value = "Attraction 객체 삽입")
//    public Map<String, String> insertProcess(@RequestBody Attraction b) throws Exception {// vo. 사용자가 입력한 값 4개를 받아옴.입력화면의 칸이름과 vo의 필드명이 일치해야 함.
//        service.insert(b);
//        Map<String, String> map = new HashMap<>();
//        map.put("result", "insert success!");
//        return map;// redirect
//    }
//    @PostMapping(value = "/customers/aa") // db에 입력
//    @ApiOperation(notes = "객체를 삽입 합니다.", value = "Attraction 객체 삽입")
//    public Map<String, String> insertProcess2(@RequestBody Car c) throws Exception {// vo. 사용자가 입력한 값 4개를 받아옴.입력화면의 칸이름과 vo의 필드명이 일치해야 함.
//        Map<String, String> map = new HashMap<>();
//        map.put("result", "insert success!");
//        return map;// redirect
//    }
//
//    @PutMapping(value = "/customers")
//    @ApiOperation(notes = "해당 Attraction 객체를 수정 합니다.", value = "Attraction 객체 수정")
//    public ResponseEntity<String> modify(@RequestBody Attraction b)throws Exception  {
//        service.update(b);
//        ResponseEntity<String> rb =
//                new ResponseEntity<String>("modify success!", HttpStatus.OK);
//        return rb;// view name
//    }
//    @DeleteMapping(value = "/customers/{num}")
//    @ApiOperation(notes = "num에 해당하는 전체 Attraction 객체를 삭제 합니다.", value = "Attraction 객체 삭제")
//    public Map<String, String> delete(@PathVariable String num)throws Exception  {
//        int x = service.delete(num);
//        Map<String, String> map = new HashMap<>();
//        if (x>=1) {
//            map.put("result", "delete success!");
//        }
//        else{
//            map.put("result", "delete fail!");
//        }
//        return map;// view name
//    }
//
//    @GetMapping(value = "/customers/find/{address}")
//    @ApiOperation(notes = "address에 해당하는 전체 Attraction 객체 리스트를 조회 합니다.", value = "Attraction address 검색")
//    public ResponseEntity<List<Attraction>> search(@PathVariable String address)throws Exception  {
//        List<Attraction> list = service.search(address);
//        return ResponseEntity.status(HttpStatus.OK).body(list);
//    }
}

