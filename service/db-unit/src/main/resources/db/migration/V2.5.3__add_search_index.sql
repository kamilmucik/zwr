CREATE INDEX product_version_indeks ON product_version (ean, art_number);
CREATE INDEX shipment_product_indeks ON shipment_product (art_number, ean);
