package galacticgames.android.skilltree.skill;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SkillDao  {

    @Insert
    void insert(Skill skill);

    @Query("DELETE FROM skill_table")
    void deleteAll();

    @Query("SELECT * from skill_table ORDER  BY title ASC")
    List<Skill> getAllSkills();

}
