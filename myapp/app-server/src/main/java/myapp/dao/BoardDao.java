package myapp.dao;

import java.util.List;
import myapp.vo.Board;

public interface BoardDao {
  void insert(Board board);
  List<Board> findAll(int category);
  Board findBy(int category, int no);
  int update(Board board);
  int updateCount(Board board);
  int delete(Board board);
}