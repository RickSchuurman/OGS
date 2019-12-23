package com.jot.ogs.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jot.ogs.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 * DAO or Data Access Object is used to interact with the database directly.
 */

@Repository("postgres")
public class ClientDataAccesService implements ClientDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDataAccesService(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertClient(final UUID id, final Client client) {
        final String sql = "INSERT INTO client (id, gender, firstname, lastname, companyname, email, phone, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
            id,
            client.getGender(),
            client.getFirstName(),
            client.getLastName(),
            client.getCompanyName(),
            client.getEmail(),
            client.getPhone(),
            client.getNote());
    }

    @Override
    public List<Client> selectAllClients() {
        final String sql = "SELECT id, gender, firstName, lastName, companyName, email, phone, note FROM client";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String gender = resultSet.getString("gender");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String companyName = resultSet.getString("companyName");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String note = resultSet.getString("note");
            return new Client(id, gender, firstName, lastName, companyName, email, phone, note);
        });
    }

    @Override
    public Optional<Client> selectClientById(final UUID id) {
        final String sql = "SELECT id, gender, firstName, lastName, companyName, email, phone, note FROM client WHERE id = ?";

        Client client = jdbcTemplate.queryForObject(sql,
            new Object[]{id},
            (resultSet, i) -> {
                UUID clientId = UUID.fromString(resultSet.getString("id"));
                String gender = resultSet.getString("gender");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String companyName = resultSet.getString("companyName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String note = resultSet.getString("note");
                return new Client(clientId, gender, firstName, lastName, companyName, email, phone, note);
            });
        return Optional.ofNullable(client);
    }

    @Override
    public int deleteClientByID(final UUID id) {
        final String sql = "DELETE FROM client WHERE id = ?";
        Optional<Client> clientPresent = selectClientById(id);
        if (clientPresent.isPresent()) {
            jdbcTemplate.update(sql, id);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateClientById(final UUID id, final Client client) {
        final String sql = "UPDATE client SET gender = ?, firstname = ?, lastname = ?, companyname  = ?, email = ?, phone = ?, note = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
            client.getGender(),
            client.getFirstName(),
            client.getLastName(),
            client.getCompanyName(),
            client.getEmail(),
            client.getPhone(),
            client.getNote(),
            id);
    }
}



