INSERT INTO is_established ($from_id, $to_id) VALUES ((SELECT $node_id FROM College WHERE id = 1), (SELECT $node_id FROM Address WHERE id = 1));
INSERT INTO is_established ($from_id, $to_id) VALUES ((SELECT $node_id FROM College WHERE id = 2), (SELECT $node_id FROM Address WHERE id = 2));
INSERT INTO is_established ($from_id, $to_id) VALUES ((SELECT $node_id FROM College WHERE id = 3), (SELECT $node_id FROM Address WHERE id = 3));
