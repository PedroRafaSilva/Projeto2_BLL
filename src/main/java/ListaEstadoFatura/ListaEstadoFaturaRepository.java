package ListaEstadoFatura;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaEstadoFaturaRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"ListaEstadoFatura\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"ListaEstadoFatura\" WHERE \"idFatura\" = ? AND \"idFatura\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"ListaEstadoFatura\" (\"idFatura\", \"idEstado\", \"data\") VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"ListaEstadoFatura\" SET \"idFatura\" = ?, \"idEstado\" = ?, \"data\" = ? WHERE \"idFatura\" = ? AND \"idFatura\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"ListaEstadoFatura\" WHERE \"idFatura\" = ? AND \"idFatura\" = ?";

    public List<ListaEstadoFatura> getAllListaEstadoFaturas() throws SQLException {
        List<ListaEstadoFatura> listaEstadoFaturas = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                ListaEstadoFatura listaEstadoFatura = new ListaEstadoFatura();
                listaEstadoFatura.setIdFatura(rs.getInt("idFatura"));
                listaEstadoFatura.setIdEstado(rs.getInt("idEstado"));
                listaEstadoFatura.setData(rs.getDate("data"));
                listaEstadoFaturas.add(listaEstadoFatura);
            }
        }
        return listaEstadoFaturas;
    }

    public ListaEstadoFatura saveListaEstadoFatura(ListaEstadoFatura listaEstadoFatura) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, listaEstadoFatura.getIdFatura());
            pstmt.setInt(2, listaEstadoFatura.getIdEstado());
            pstmt.setDate(3, listaEstadoFatura.getData());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    listaEstadoFatura.setIdFatura(rs.getInt(1));
                    listaEstadoFatura.setIdEstado(rs.getInt(2));
                }
            }
        }
        return listaEstadoFatura;
    }

    public ListaEstadoFatura findListaEstadoFaturaByIds(int id, int id2) throws SQLException {
        ListaEstadoFatura listaEstadoFatura = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, id2);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    listaEstadoFatura = new ListaEstadoFatura();
                    listaEstadoFatura.setIdFatura(rs.getInt("idFatura"));
                    listaEstadoFatura.setIdEstado(rs.getInt("idEstado"));
                    listaEstadoFatura.setData(rs.getDate("data"));
                }
            }
        }
        return listaEstadoFatura;
    }

    public ListaEstadoFatura updateListaEstadoFatura(ListaEstadoFatura listaEstadoFatura) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setInt(1, listaEstadoFatura.getIdFatura());
            pstmt.setInt(2, listaEstadoFatura.getIdEstado());
            pstmt.setDate(3, listaEstadoFatura.getData());
            pstmt.executeUpdate();
        }
        return listaEstadoFatura;
    }

    public void deleteListaEstadoFatura(int id, int id2) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.setInt(1, id2);
            pstmt.executeUpdate();
        }
    }
}

