package components;

import entity.Member;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@AllArgsConstructor
public class MemberStorage {


    private Map<String, Member> members = new HashMap<>();

    public void addMember(Member member){
       members.put(member.getNif(),member);
    }
    public void removeMember(String nif){
        members.remove(nif);
    }
    public List<Member> listMembers(){
        return members.values().stream().collect(Collectors.toList());
    }
}
