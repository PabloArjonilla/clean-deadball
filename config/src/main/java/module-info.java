module pmac.example.config {
	exports es.pmac.config;

	requires pmac.example.usecase;
	requires pmac.example.domain;
	requires pmac.example.jug;
	requires pmac.example.uuid;
	requires pmac.example.db.simple;
	requires pmac.example.db.hazelcast;
	requires pmac.example.encoder;
}
