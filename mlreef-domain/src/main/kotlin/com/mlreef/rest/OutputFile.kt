package com.mlreef.rest

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Descriptor of an Output, which could be a Gitlab Artifact, an S3 Bucket or many more.
 *
 *
 */

@Entity
@Table(name = "output_file")
class OutputFile(
    @Id @Column(name = "id", length = 16, unique = true, nullable = false) val id: UUID,

    @Column(name = "experiment_id")
    val experimentId: UUID?,

    @Column(name = "data_processor_id")
    val dataProcessorId: UUID?
)
