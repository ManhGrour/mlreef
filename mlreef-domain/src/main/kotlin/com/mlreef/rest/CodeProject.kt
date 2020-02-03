package com.mlreef.rest

import java.time.ZonedDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

/**
 * A Code Repository is used for the working Code like Data Operations,
 * Algorithms, or soon Visualisations.
 *
 * A
 */
@Entity
@Table(name = "code_project")
class CodeProject(
    id: UUID,
    override val slug: String,
    override val url: String,
    override val name: String,
    @Column(name = "owner_id")
    override val ownerId: UUID,

    @Column(name = "gitlab_group")
    override val gitlabGroup: String,

    @Column(name = "gitlab_project")
    override val gitlabProject: String,

    @Column(name = "gitlab_id")
    override val gitlabId: Int,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "code_project_id")
    val dataProcessor: DataProcessor? = null,

    version: Long? = null,
    createdAt: ZonedDateTime? = null,
    updatedAt: ZonedDateTime? = null

) : AuditEntity(id, version, createdAt, updatedAt), MLProject {
    fun copy(
        url: String? = null,
        slug: String? = null,
        name: String? = null,
        gitlabGroup: String? = null,
        gitlabProject: String? = null,
        gitlabId: Int? = null,
        dataProcessor: DataProcessor? = null,
        version: Long? = null,
        createdAt: ZonedDateTime? = null,
        updatedAt: ZonedDateTime? = null
    ): CodeProject {
        return CodeProject(
            id = this.id,
            slug = slug ?: this.slug,
            url = url ?: this.url,
            name = name ?: this.name,
            ownerId = this.ownerId,
            gitlabGroup = gitlabGroup ?: this.gitlabGroup,
            gitlabProject = gitlabProject ?: this.gitlabProject,
            gitlabId = gitlabId ?: this.gitlabId,
            dataProcessor = dataProcessor ?: this.dataProcessor,
            version = version ?: this.version,
            createdAt = createdAt ?: this.createdAt,
            updatedAt = updatedAt ?: this.updatedAt
        )
    }
}
