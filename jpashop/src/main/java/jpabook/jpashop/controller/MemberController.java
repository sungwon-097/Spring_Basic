package jpabook.jpashop.controller;

import jpabook.jpashop.Service.MemberService;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm",new MemberForm()); // 컨트롤러에서 뷰로 넘어갈 때 해당 데이터를 실어서 보냄
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result){ // 오류를 BindingResult로 담겨져 아래코드를 실행

        if (result.hasErrors()){
            return "members/createMemberForm"; // @NotEmpty 메시지가 출력됨 createMemberForm.html 에 있음
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); // API를 만들때에는 이와같이 엔티티를 넘기면 절대 안된다. 멤버 엔티티에 password 같은게 있을 수 있다. 엔티티 로직 추가하면 API 스펙 변경됨.
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
