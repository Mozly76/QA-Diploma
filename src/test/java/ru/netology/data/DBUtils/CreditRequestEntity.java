package ru.netology.data.DBUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditRequestEntity {
    private String id;
    private String bank_id;
    private String created;
    private String status;
}