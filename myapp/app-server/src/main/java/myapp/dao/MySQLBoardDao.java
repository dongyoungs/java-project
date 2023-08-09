package myapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import myapp.vo.Board;

public class MySQLBoardDao implements BoardDao{
  SqlSessionFactory sqlSessionFactory;

  public MySQLBoardDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Board board) {
    System.out.println(board.getCategory());
    System.out.println(board.getContent());
    System.out.println(board.getTitle());
    System.out.println(board.getWriter().getNo());
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("myapp.dao.BoardDao.insert", board);

  }

  @Override
  public List<Board> findAll(int category) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectList("myapp.dao.BoardDao.findAll",category);
  }

  @Override
  public Board findBy(int category, int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);

    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("categoryNo", category);
    paramMap.put("boardNo",no);
    return sqlSession.selectOne("myapp.dao.BoardDao.findBy", paramMap);
  }

  @Override
  public int update(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("myapp.dao.BoardDao.update", board);
  }

  @Override
  public int updateCount(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("myapp.dao.BoardDao.updateCount", board);
  }

  @Override
  public int delete(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.delete("myapp.dao.BoardDao.delete",board);
  }
}
