package com.zkiss.proman.controller;

import com.zkiss.proman.model.BoardColumn;
import com.zkiss.proman.model.DTO.boardcolumnDTO.BoardColumnCreateRequest;
import com.zkiss.proman.model.DTO.boardcolumnDTO.BoardColumnDeleteRequest;
import com.zkiss.proman.service.BoardColumnService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boardcolumn")
public class BoardColumnController {

    private BoardColumnService boardColumnService;


    public BoardColumnController(BoardColumnService boardColumnService) {
        this.boardColumnService = boardColumnService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNewBoardColumn(@RequestBody BoardColumnCreateRequest createRequest){
        if(createRequest.hasNoNullField()){
            boardColumnService.registerBoardColumn(createRequest);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(401).body("Missing BoardColumn Information");
        }
    }

    @PutMapping("/update")
    public void updateBoardColumn(@RequestBody BoardColumn boardColumn){

        boardColumnService.update(boardColumn);
    }

    @DeleteMapping
    public void deleteBoardColumn(@RequestBody BoardColumnDeleteRequest deleteRequest){

        boardColumnService.delete(deleteRequest);
    }


}
