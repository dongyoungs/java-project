package myapp.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import myapp.vo.Member;

public class MySQLMemberDao implements MemberDao {

  SqlSessionFactory sqlSessionFactory;

  public MySQLMemberDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("myapp.dao.MemberDao.insert", member);
  }

  @Override
  public List<Member> findAll() {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectList("myapp.dao.MemberDao.findAll");
  }

  @Override
  public Member findBy(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectOne("myapp.dao.MemberDao.findBy", no);
  }

  @Override
  public Member findByEmailAndPassword(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectOne("myapp.dao.MemberDao.findByEmailAndPassword", member);
  }

  @Override
  public int update(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("myapp.dao.MemberDao.update", member);
  }

  @Override
  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.delete("myapp.dao.MemberDao.delete", no);
  }

}
