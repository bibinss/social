package com.video.social.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.video.social.api.ResponseStatusCode.SUCCESS;

@RestController
@RequestMapping("/api")
public class ClassApi {

    @PostMapping("/classes")
    public ResponseEntity<Class> createClass(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                             @RequestBody ClassForm teamForm) {
        return new ResponseEntity(new Class(), HttpStatus.OK);
    }

    @GetMapping("/classes")
    public ResponseEntity<ClassesGetResult> getClasses(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new ResponseEntity(new ClassesGetResult(), HttpStatus.OK);
    }

    @DeleteMapping("/classes/{classId}")
    public ResponseEntity<ClassesGetResult> getClasses(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                       @PathVariable(name = "classId") String classId) {
        return new ResponseEntity(new ClassDeleteResult(new ResponseStatus(SUCCESS, "Successfully Deleted")), HttpStatus.OK);
    }

    @PostMapping("/classes/{classId}/files/add")
    public ResponseEntity<ClassAddFileResult> addClassFile(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                             @PathVariable (name="classId") String classId,
                                             @RequestBody ClassAddFileForm addFileForm) {
        return new ResponseEntity(new ClassAddFileResult(new ResponseStatus(SUCCESS, "Successfully Added")), HttpStatus.OK);
    }

    @PostMapping("/classes/{classId}/files/remove")
    public ResponseEntity<ClassAddFileResult> removeClassFile(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                      @PathVariable (name="classId") String classId,
                                                      @RequestBody ClassAddFileForm addFileForm) {
        return new ResponseEntity(new ClassDeleteResult(new ResponseStatus(SUCCESS, "Successfully Removed")), HttpStatus.OK);
    }

    @PostMapping("/classes/{classId}/members/{memberId}/files/add")
    public ResponseEntity<ClassAddFileResult> addClassMemberFile(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                      @PathVariable (name="classId") String classId,
                                                      @PathVariable (name="memberId") String memberId,
                                                      @RequestBody ClassAddFileForm addFileForm) {
        return new ResponseEntity(new ClassAddFileResult(new ResponseStatus(SUCCESS, "Successfully Added")), HttpStatus.OK);
    }

    @PostMapping("/classes/{classId}/members/{memberId}/files/remove")
    public ResponseEntity<ClassAddFileResult> removeClassMemberFile(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                         @PathVariable (name="classId") String classId,
                                                         @PathVariable (name="memberId") String memberId,
                                                         @RequestBody ClassAddFileForm addFileForm) {
        return new ResponseEntity(new ClassDeleteResult(new ResponseStatus(SUCCESS, "Successfully Removed")), HttpStatus.OK);
    }
}
