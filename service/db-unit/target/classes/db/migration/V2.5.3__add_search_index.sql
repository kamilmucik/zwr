-- CREATE INDEX product_version_revision_indeksu ON product_version_revision (kolumna1, kolumna2);
CREATE INDEX product_version_indeks ON product_version (ean, art_number);
-- CREATE INDEX shipment_indeksu ON shipment (kolumna1, kolumna2);
-- CREATE INDEX shipment_event_indeksu ON shipment_event (kolumna1, kolumna2);
CREATE INDEX shipment_product_indeks ON shipment_product (art_number, ean);
-- CREATE INDEX shipment_product_shop_indeksu ON shipment_product_shop (kolumna1, kolumna2);
