package servlet;

import entity.Goods;
import entity.Order;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/pay")
public class ReadByServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String goodsIdAndNum = req.getParameter("goodsIdAndNum");
        String[] strings = goodsIdAndNum.split(",");

        List<Goods> goodsList = new ArrayList<>();

        for (String s : strings) {
            String[] strings1 = s.split("-");
            Goods goods = this.getGoods(Integer.valueOf(strings1[0]));
            if (goods != null) {
                goodsList.add(goods);
                goods.setBuyGoodsNum(Integer.valueOf(strings1[1]));
            }
        }

        System.out.println("当前需要购买" + goodsList);


        Order order = new Order();

    }
    private Goods getGoods(int goodId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Goods goods = null;
        try {
            String sql = "select *from goods where id=?";
            connection = DBUtil.getConnection(true);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1,goodId);

            resultSet = preparedStatement.executeQuery();


            if(resultSet.next()) {
                goods = this.extractGoods(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return goods;
    }

    //解析resultSet当中的商品信息，组装从一个商品的对象goods
    public Goods extractGoods(ResultSet resultSet) throws SQLException {
        Goods goods = new Goods();
        goods.setId(resultSet.getInt("id"));
        goods.setName(resultSet.getString("name"));
        goods.setIntroduce(resultSet.getString("introduce"));
        goods.setStock(resultSet.getInt("stock"));
        goods.setUnit(resultSet.getString("unit"));
        goods.setPrice(resultSet.getInt("price"));
        goods.setDiscount(resultSet.getInt("discount"));
        return goods;
    }
}
