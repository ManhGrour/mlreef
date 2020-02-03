package com.mlreef.rest.external_api.gitlab.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.mlreef.rest.external_api.gitlab.DeployStrategy
import com.mlreef.rest.external_api.gitlab.GitStrategy
import com.mlreef.rest.external_api.gitlab.GitlabAccessLevel
import com.mlreef.rest.external_api.gitlab.GitlabState
import com.mlreef.rest.external_api.gitlab.GitlabVisibility
import com.mlreef.rest.external_api.gitlab.MergeMethod

@JsonIgnoreProperties(ignoreUnknown = true)
class GitlabProject(
    val id: Long,
    val name: String,
    val nameWithNamespace: String?,
    val path: String,
    val pathWithNamespace: String,
    val owner: GitlabUser,
    val creatorId: Long,
    val createdAt: String = "",
    val description: String? = null,
    val defaultBranch: String? = null,
    val tagList: List<String> = listOf(),
    val sshUrlToRepo: String = "",
    val httpUrlToRepo: String = "",
    val webUrl: String = "",
    val readmeUrl: String? = null,
    val avatarUrl: String? = null,
    val starCount: Long = 0,
    val forksCount: Long = 0,
    val lastActivityAt: String? = null,
    val namespace: GitlabNamespace? = null,
    @JsonProperty("_links")
    val links: Map<String, String> = mapOf(),
    val emptyRepo: Boolean = true,
    val archived: Boolean = true,
    val visibility: GitlabVisibility = GitlabVisibility.INTERNAL,
    val resolveOutdatedDiffDiscussions: Boolean = false,
    val containerRegistryEnabled: Boolean = true,
    val issuesEnabled: Boolean = true,
    val mergeRequestsEnabled: Boolean = true,
    val wikiEnabled: Boolean = true,
    val jobsEnabled: Boolean = true,
    val snippetsEnabled: Boolean = true,
    val issuesAccessLevel: GitlabAccessLevel = GitlabAccessLevel.ENABLED,
    val repositoryAccessLevel: GitlabAccessLevel = GitlabAccessLevel.ENABLED,
    val wikiAccessLevel: GitlabAccessLevel = GitlabAccessLevel.ENABLED,
    val buildsAccessLevel: GitlabAccessLevel = GitlabAccessLevel.ENABLED,
    val snippetsAccessLevel: GitlabAccessLevel = GitlabAccessLevel.ENABLED,
    val sharedRunnersEnabled: Boolean = true,
    val lfsEnabled: Boolean = true,
    val importStatus: String? = null,
    val importError: String? = null,
    val openIssuesCount: Int = 0,
    val runnersToken: String? = null,
    val ciDefaultGitDepth: Int = 0,
    val publicJobs: Boolean = true,
    val buildGitStrategy: GitStrategy = GitStrategy.FETCH,
    val buildTimeout: Long = 0,
    val autoCancelPendingPipelines: GitlabState = GitlabState.ENABLED,
    val buildCoverageRegex: String? = null,
    val ciConfigPath: String? = null,
    val sharedWithGroups: List<SharedGroup> = listOf(),
    val onlyAllowMergeIfPipelineSucceeds: Boolean = false,
    val requestAccessEnabled: Boolean = true,
    val onlyAllowMergeIfAllDiscussionsAreResolved: Boolean = false,
    val removeSourceBranchAfterMerge: Boolean = true,
    val printingMergeRequestLinkEnabled: Boolean = true,
    val mergeMethod: MergeMethod = MergeMethod.MERGE,
    val autoDevopsEnabled: Boolean = true,
    val autoDevopsDeployStrategy: DeployStrategy = DeployStrategy.CONTINUOUS
)
